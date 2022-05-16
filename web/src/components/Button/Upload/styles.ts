import styled from "styled-components";

export const Container = styled.div`
  input[type="file"] {
    display: none;
  }

  display: flex;
  align-items: center;
  justify-content: flex-start;
`;

export const FileInput = styled.input``;

export const Text = styled.label`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
  font-size: 1rem;
  width: 200px;
  height: 60px;
  background-color: #318cd6;
  color: #fff;
  text-transform: uppercase;
  cursor: pointer;
  border-radius: 0.4rem;
  transition: all 0.4s;

  box-shadow: 1px 1px 4px #555;

  &:hover {
    background-color: #1e5c8f;
  }
`;

export const ButtonUpload = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
  width: 200px;
  height: 60px;
  background-color: #7831d6;
  cursor: pointer;
  border-radius: 0.4rem;
  transition: all 0.4s;
  box-shadow: 1px 1px 4px #555;
  border: none;

  &:hover {
    background-color: #582897;
  }
`;

export const TextUpload = styled.label`
  color: #fff;
  font-size: 1rem;
  text-transform: uppercase;
  cursor: pointer;
`;
