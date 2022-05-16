import React, { ChangeEvent, useCallback, useState } from "react";
import { FiSend, FiUpload } from "react-icons/fi";
import Aux from "../../Aux";
import Loading from "../../Loading";
import { useApp } from "../../../contexts/AppProvider";
import { ButtonUpload, Container, FileInput, Text, TextUpload } from "./styles";

const Upload: React.FC = () => {
  const [fileSelected, setFileSelected] = useState<File>();
  const [loading, setLoading] = useState(false);

  const { uploadFile } = useApp();

  const handleImageChange = useCallback((event: ChangeEvent<HTMLInputElement>) => {
    const fileList = event.target.files;

    if (!fileList) return;

    setFileSelected(fileList[0]);
  }, []);

  const handleUpload = useCallback(async () => {
    if (fileSelected) {
      setLoading(true);
      await uploadFile(fileSelected);

      setTimeout(() => {
        setFileSelected(undefined);
        setLoading(false);
      }, 1000);
    }
  }, [fileSelected, uploadFile]);

  const getComponentUpload = useCallback(() => {
    if (loading) return <Loading />;

    return (
      <Aux>
        Importar <FiUpload size={30} style={{ marginLeft: 20 }} />
        <FileInput accept="text/plain" type="file" name="file" id="file" onChange={handleImageChange} />
      </Aux>
    );
  }, [loading, handleImageChange]);

  const getComponentSend = useCallback(() => {
    if (loading) return <Loading />;

    return (
      <Aux>
        <TextUpload>Enviar</TextUpload>
        <FiSend size={30} color="#fff" style={{ marginLeft: 20 }} />
      </Aux>
    );
  }, [loading]);

  const getComponentWithFileVerification = useCallback(() => {
    if (!fileSelected) {
      return <Text htmlFor="file">{getComponentUpload()}</Text>;
    } else {
      return (
        <ButtonUpload type="button" onClick={handleUpload}>
          {getComponentSend()}
        </ButtonUpload>
      );
    }
  }, [fileSelected, handleUpload, getComponentSend, getComponentUpload]);

  return <Container>{getComponentWithFileVerification()}</Container>;
};

export default Upload;
