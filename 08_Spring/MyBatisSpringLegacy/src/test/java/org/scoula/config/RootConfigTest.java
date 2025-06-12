package org.scoula.config;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RootConfig.class })
@Log4j2
class RootConfigTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Test
    public void testSqlSessionFactory() {
        try (
                //세션 열기
                SqlSession session = sqlSessionFactory.openSession();
                //세션을 통해 jdbc커넥션 획득
                Connection con = session.getConnection();
        ) {
            log.info(session); // 세션 정보 출력
            log.info(con); // 커넥션 정보 출력
        } catch (Exception e) {
            fail(e.getMessage()); // 실패 시 예외 메시지 출력
        }
    }

}