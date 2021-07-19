package com.sparta.eng87.spartaglobal_vhswebsite;

import com.sparta.eng87.spartaglobal_vhswebsite.POJO.AdvancedSearchTerms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xmlunit.util.IterableNodeList;

public class AdvancedSearchTermsTest {


    @Test
    void shouldSetTitle(){
        AdvancedSearchTerms terms = new AdvancedSearchTerms();
        terms.setTitle("Fred");
        Assertions.assertEquals("Fred",terms.getTitle());
    }

    @Test
    void shouldSetFirstName(){
        AdvancedSearchTerms terms = new AdvancedSearchTerms();
        terms.setFirstName("Arnold");
        Assertions.assertEquals("Arnold",terms.getFirstName());
    }

    @Test
    void shouldSetLastName(){
        AdvancedSearchTerms terms = new AdvancedSearchTerms();
        terms.setLastName("schwarzenegger");
        Assertions.assertEquals("schwarzenegger",terms.getLastName());
    }

    @Test
    void shouldSetGenre(){
        AdvancedSearchTerms terms = new AdvancedSearchTerms();
        terms.setGenre("Action");
        Assertions.assertEquals("Action",terms.getGenre());
    }


}
