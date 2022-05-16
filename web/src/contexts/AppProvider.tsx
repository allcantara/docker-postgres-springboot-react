import React, { createContext, ReactNode, useCallback, useContext, useState } from "react";
import { toast } from "react-toastify";
import api from "../services/api";
import Transaction from "../types/Transaction";

const ERROR_RELOAD = "Ocorreu um erro ao atualizar. Entre em contato com o desenvolvedor: brunoalcantarajc@gmail.com.";
const ERROR_UPLOAD = "Ocorreu um erro ao enviar o arquivo. Entre em contato com o desenvolvedor: brunoalcantarajc@gmail.com.";

type MessageProps = {
  message: string;
  type: "success" | "error";
};

export type AppContextProps = {
  showMessage: (props: MessageProps) => void;
  uploadFile: (props: File) => Promise<void>;
  findAllTransactions: () => Promise<void>;
  transactions: Transaction[];
};

const AppContext = createContext({} as AppContextProps);

type AppProps = {
  children: ReactNode;
};

const AppProvider = ({ children }: AppProps) => {
  const [transactions, setTransactions] = useState<Transaction[]>([]);

  const showMessage = useCallback(({ message, type }: MessageProps) => {
    toast(message, { type });
  }, []);

  const findAllTransactions = useCallback(async () => {
    try {
      const response = await api.get<Transaction[]>("/transaction");

      if (response.status !== 200) {
        showMessage({
          message: ERROR_RELOAD,
          type: "error",
        });
      }

      setTransactions(response.data);
    } catch (error) {
      showMessage({
        message: ERROR_RELOAD,
        type: "error",
      });
    }
  }, [showMessage]);

  const uploadFile = useCallback(
    async (file: File) => {
      try {
        if (file) {
          const data = new FormData();
          data.append("file", file, file.name);

          const response = await api.post("/transaction", data);

          if (response.status !== 200) {
            showMessage({
              message: ERROR_UPLOAD,
              type: "error",
            });
          }

          showMessage({
            message: "Arquivo processado com sucesso!",
            type: "success",
          });

          findAllTransactions();
        }
      } catch (error) {
        showMessage({
          message: ERROR_UPLOAD,
          type: "error",
        });
      }
    },
    [showMessage, findAllTransactions]
  );

  return (
    <AppContext.Provider
      value={{
        showMessage,
        uploadFile,
        findAllTransactions,
        transactions,
      }}
    >
      {children}
    </AppContext.Provider>
  );
};

const useApp = () => {
  const context = useContext(AppContext);

  if (!context) {
    throw new Error("'useApp' must be used within a 'AppProvider'");
  }

  return context;
};

export { AppContext, AppProvider, useApp };
