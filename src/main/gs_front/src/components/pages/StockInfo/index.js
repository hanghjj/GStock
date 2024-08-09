import React, { useState } from "react";
import styled from "styled-components";
import SearchCondition from "./SearchCondition";
import InfoList from "./InfoList";
import CodeList from "./CodeList";
import axios from "axios";

// Styled Components
const PageContainer = styled.div`
  width: 100%;
  height: 100%;
  flex-basis: 500px;
  background-color: aliceblue;
`;

const ResultContainer = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
`;

const StockInfo = () => {
  const [codeList, setCodeList] = useState([]);
  const [infoList, setInfoList] = useState([]);
  const [stckNm, setStckNm] = useState("");

  /**
   * 조회버튼 클릭
   */
  const onClickSearch = (event) => {
    event.preventDefault();
    axios
      .get(`/api/stock/code/${stckNm}`)
      .then((response) => {
        console.log(response.data);
        setCodeList(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  /**
   * 그리드 클릭
   */
  const onCellClicked = (params) => {
    axios
      .get(`/api/stock/kis/info/${params.data.cd}`)
      .then((response) => {
        setInfoList(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <PageContainer>
      <SearchCondition
        stckNm={stckNm}
        setStckNm={setStckNm}
        onClickSearch={onClickSearch}
      />
      <ResultContainer>
        <CodeList codeList={codeList} onCellClicked={onCellClicked} />
        <InfoList infoList={infoList} />
      </ResultContainer>
    </PageContainer>
  );
};
export default StockInfo;
