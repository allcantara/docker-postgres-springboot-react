import styled from "styled-components";

export const Container = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
  width: 200px;
  height: 60px;
  background-color: #21ad59;
  cursor: pointer;
  border-radius: 0.4rem;
  transition: all 0.4s;
  box-shadow: 1px 1px 4px #555;
  border: none;

  &:hover {
    background-color: #198142;
  }
`;

export const Text = styled.label`
  color: #fff;
  font-size: 1rem;
  text-transform: uppercase;
  cursor: pointer;
`;
