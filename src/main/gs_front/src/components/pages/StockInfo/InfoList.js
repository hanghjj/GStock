import React from "react";
import styled from "styled-components";

const InfoBox = styled.div`
  width: 50%;
  height: 100%;
`;

const Title = styled.div`
  width: 500px;
  height: 50px;
  font-size: 20px;
  background-color: beige;
`;

const InfoList = (infoList) => {
  return (
    <InfoBox>
      <Title>{infoList?.infoList?.itmNm}</Title>
      <Title>{infoList?.infoList?.bseDt}</Title>
      <Title>현재가격 {infoList?.infoList?.stkPrpr}</Title>
      <Title>등락 {infoList?.infoList?.prdyVrss}</Title>
      <Title>최고가 {infoList?.infoList?.hgpr}</Title>
      <Title>최저가 {infoList?.infoList?.lwpr}</Title>
      <Title>52주 최고가 {infoList?.infoList?.hgprW52}</Title>
      <Title>52주 최저가 {infoList?.infoList?.lwprW52}</Title>
    </InfoBox>
  );
};

export default InfoList;
