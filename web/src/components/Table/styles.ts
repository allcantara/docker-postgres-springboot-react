import styled from "styled-components";

export const Container = styled.div`
  margin: 2rem 0;
  width: 100%;
  padding: 0.7rem 2.2rem 1.2rem 2.2rem;
  margin: 2rem 0;
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 0.4rem;
  box-shadow: 0 4px 8px #ddd;
`;

export const TableContainer = styled.table`
  width: 100%;
  border-spacing: 0px;
`;

export const TableHeader = styled.thead``;

export const TableBody = styled.tbody``;

type ItemProps = {
  activeColor?: boolean;
};

export const TableItemContainer = styled.tr<ItemProps>`
  th {
    padding: 0.5rem 0.5rem;
    background-color: #fff;
    font-weight: bold;
    border-bottom: 1px solid #000;
  }

  td {
    padding: 0.8rem 0.5rem;
    border-bottom-width: 1px;
    text-align: center;
    border-bottom: 1px solid #eee;
    background-color: ${(props) => (props.activeColor ? "#eee" : "#fff")};
  }
`;

type AccountBallanceProps = {
  value: number;
};

export const AccountBallanceText = styled.span<AccountBallanceProps>`
  font-weight: bold;
  color: ${(props) => (props.value === 0 ? "#000" : props.value > 0 ? "#1a721d" : "#c93737")};
`;
