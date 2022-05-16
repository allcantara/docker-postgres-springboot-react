import { createGlobalStyle } from "styled-components";

export const AppContainer = createGlobalStyle`
    * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }
  
  html, body {
    color: #000;
    background-color: #ffffff;
    padding: 2rem 3rem;
  }
`;
