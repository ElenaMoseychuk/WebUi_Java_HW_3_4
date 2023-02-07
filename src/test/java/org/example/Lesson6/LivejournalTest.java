package org.example.Lesson6;


import org.example.Lesson5.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LivejournalTest extends AbstractTest {

    public static Logger logger = LoggerFactory.getLogger(org.example.Lesson5.LivejournalTest.class);

    @Test
    void Search() {
        Search Search = new Search(getDriver());
        Search
        .clickWebElement1()
        .sendKeysWebElement2()
        .clickWebElement3();
         Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://www.livejournal.com/rsearch?q=%D0%9A%D0%B8%D0%BD%D0%BE&sort=_score&searchArea=post"));
         logger.info("Кнопка Написать");
    }

    @Test
    void ButtonWrite() {
        ButtonWrite ButtonWrite = new ButtonWrite(getDriver());
        ButtonWrite
       .clickWebElement1()
       .clickWebElement2()
       .clickWebElement3();
        logger.info("Кнопка Написать");
    }

    @Test
    void CheckProfile() {
        CheckProfile ChechProfile = new CheckProfile(getDriver());
        ChechProfile
                .clickWebElement1()
                .clickWebElement2()
                .clickWebElement3();
        String urlCard = "https://myatochka-life.livejournal.com/profile";
        Assertions.assertEquals(urlCard, getDriver().getCurrentUrl());
        logger.info("Профиль пользователя");
    }

    @Test
    void Auth() {
       Auth Auth = new Auth(getDriver());
       Auth
                .clickWebElement1()
                .sendKeysWebElement2()
                .sendKeysWebElement3()
                .clickWebElement4();
               logger.info("Авторизация");
    }
    }

