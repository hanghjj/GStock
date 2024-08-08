/**
 * 조회
 */
import React from "react";
import styled from "styled-components";

const SearchBox = styled.div`
  width: 500px;
  height: 58px;
  border-width: 1px;
  border-radius: 9999px;
  line-height: 17px;
  margin-bottom: 1rem;
  display: flex;
`;

const Input = styled.input`
  width: 100%;
  padding: 1.25rem 27px 15px 27px;
  outline: 2px solid transparent;
  outline-offset: 2px;
  background-color: #f8f9fa;
  color: #333;
  box-sizing: border-box;

  &:focus {
    background-color: #ffffff;
  }
`;

const SearchButton = styled.button`
  width: 100px;
  height: 58px;
`;

const SearchCondition = ({ stckNm, setStckNm, onClickSearch }) => {
  const onChange = (e) => {
    e.preventDefault();
    setStckNm(e.target.value);
  };

  return (
    <div>
      <SearchBox>
        <Input
          type="text"
          id="stckNm"
          placeholder="종목명"
          value={stckNm}
          required
          onChange={onChange}
        />
        <SearchButton onClick={onClickSearch}>조회</SearchButton>
      </SearchBox>
    </div>
  );
};

export default SearchCondition;
