package com.hellomygreenworld.ex02.mapper;

import com.hellomygreenworld.ex02.domain.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml")
@Log4j
public class BoardMapperTests {

    @Setter(onMethod_ = {@Autowired})
    private BoardMapper mapper;

    @Test
    public void testGetList() {
        log.info(mapper.getList());
        mapper.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testInsert() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("inserted title");
        boardVO.setContent("inserted content");
        boardVO.setWriter("inserted writer");

        mapper.insert(boardVO);
        log.info(boardVO);
    }

    @Test
    public void testInsertSelectKey() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("inserted title select key");
        boardVO.setContent("inserted content select key");
        boardVO.setWriter("inserted writer select key");

        mapper.insert(boardVO);
        log.info(boardVO);
    }

    @Test
    public void testRead() {

        BoardVO boardVO = mapper.read(5);
        log.info(mapper);
    }

    @Test
    public void testDelete() {
        log.info("DELETE COUNT: " + mapper.delete(8));
    }

    @Test
    public void testUpdate() {
        BoardVO boardVO = new BoardVO();
        boardVO.setBno(5);
        boardVO.setTitle("updated title");
        boardVO.setContent("updated content");
        boardVO.setWriter("updated writer");

        int count = mapper.update(boardVO);
        log.info("UPDATE COUNT: " + count);
    }

}