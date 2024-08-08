import React, { useEffect } from "react";
import styled from "styled-components";

const InfoBox = styled.div`
  width: 50%;
  height: 100%;
`;

const Title = styled.div`
  width: 100px;
  height: 100px;
  font-size: 20px;
  background-color: beige;
`;

const InfoList = (infoList) => {
  useEffect(() => {
    console.log(infoList.bseDt);
  }, [infoList]);
  return (
    <InfoBox>
      <Title>안녕{infoList?.itmNm}</Title>
    </InfoBox>
  );
};

export default InfoList;
