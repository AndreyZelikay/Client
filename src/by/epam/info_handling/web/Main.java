package by.epam.info_handling.web;

import by.epam.info_handling.service.ServiceFactory;
import by.epam.info_handling.service.TextService;

public class Main {

    public static void main(String[] args) {
        TextService textService = ServiceFactory.getInstance().getTextService();

        System.out.println(textService.getSentencesWithRepeatedWords());
    }
}
