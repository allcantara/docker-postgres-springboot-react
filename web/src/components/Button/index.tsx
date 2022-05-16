import React from "react";
import Reload from "./Reload";
import Upload from "./Upload";
import { Container } from "./styles";

type ButtonProps = {
  type: "UPLOAD" | "RELOAD";
};

const Button: React.FC<ButtonProps> = ({ type }) => {
  return <Container>{type === "UPLOAD" ? <Upload /> : <Reload />}</Container>;
};

export default Button;
