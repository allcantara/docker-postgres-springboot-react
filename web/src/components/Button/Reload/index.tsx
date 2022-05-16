import React, { useCallback, useEffect, useState } from "react";
import { FiRefreshCcw } from "react-icons/fi";
import Aux from "../../Aux";
import Loading from "../../Loading";
import { useApp } from "../../../contexts/AppProvider";
import { Container, Text } from "./styles";

const Reload: React.FC = () => {
  const [loading, setLoading] = useState(false);

  const { findAllTransactions } = useApp();

  useEffect(() => {
    findAllTransactions().then();
  }, [findAllTransactions]);

  const handleReload = useCallback(async () => {
    setLoading(true);

    await findAllTransactions();

    setTimeout(() => {
      setLoading(false);
    }, 1000);
  }, [findAllTransactions]);

  return (
    <Container disabled={loading} onClick={handleReload}>
      {loading ? (
        <Loading />
      ) : (
        <Aux>
          <Text>Atualizar</Text>
          <FiRefreshCcw size={30} color="#fff" style={{ marginLeft: 20 }} />
        </Aux>
      )}
    </Container>
  );
};

export default Reload;
