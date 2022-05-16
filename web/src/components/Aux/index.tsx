import React, { ReactNode } from "react";

type Props = {
  children?: ReactNode;
};

const Aux: React.FC<Props> = ({ children }) => <React.Fragment>{children}</React.Fragment>;

export default Aux;
