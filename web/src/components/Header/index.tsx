import React from "react";
import Button from "../Button";
import { ButtonContainer, Container, Subtitle, Title, TitleContainer } from "./styles";

const Header: React.FC = () => {
  return (
    <Container>
      <TitleContainer>
        <Title>Desafio ByCoders</Title>
        <Subtitle>Desafio programação - para vaga desenvolvedor.</Subtitle>
      </TitleContainer>
      <ButtonContainer>
        <Button type="UPLOAD" />
        <Button type="RELOAD" />
      </ButtonContainer>
    </Container>
  );
};

export default Header;
