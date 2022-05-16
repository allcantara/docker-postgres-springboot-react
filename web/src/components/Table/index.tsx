import React from "react";
import { useApp } from "../../contexts/AppProvider";
import { AccountBallanceText, Container, TableBody, TableContainer, TableHeader, TableItemContainer } from "./styles";

const Table: React.FC = () => {
  const { transactions } = useApp();

  return (
    <Container>
      <TableContainer>
        <TableHeader>
          <TableItemContainer>
            <th>#</th>
            <th>Nº de transações</th>
            <th>Loja</th>
            <th>Proprietário</th>
            <th>Saldo em conta</th>
          </TableItemContainer>
        </TableHeader>
        <TableBody>
          {transactions.map((item, index) => (
            <TableItemContainer key={index} activeColor={index % 2 !== 1}>
              <td>{index + 1}</td>
              <td>{item.amountTransaction}</td>
              <td>{item.storeName}</td>
              <td>{item.ownerName}</td>
              <td>
                <AccountBallanceText value={item.accountBalance}>{item.accountBalance.toLocaleString("pt-br", { style: "currency", currency: "BRL" })}</AccountBallanceText>
              </td>
            </TableItemContainer>
          ))}
        </TableBody>
      </TableContainer>
    </Container>
  );
};

export default Table;
