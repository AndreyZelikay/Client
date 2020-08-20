package by.epam.info_handling.service.impl;

import by.epam.info_handling.domain.entity.Sentence;
import by.epam.info_handling.domain.entity.Text;
import by.epam.info_handling.service.TextService;
import by.epam.info_handling.service.exception.ServiceException;
import by.epam.info_handling.web.SocketWrapper;

import java.io.IOException;
import java.util.List;

public class TextServiceImpl implements TextService {

    private final SocketWrapper socketWrapper = SocketWrapper.getInstance();

    @Override
    public Text getText() {
        try {
            socketWrapper.writeMessage("text: get text");
            return socketWrapper.readObject();
        } catch (IOException|ClassNotFoundException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Sentence> getSentencesWithRepeatedWords() {
        try {
            socketWrapper.writeMessage("text: sentences with repeated words");
            return socketWrapper.readObject();
        } catch (IOException|ClassNotFoundException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Sentence> getSentencesInAscendingOrderOfWords() {
        try {
            socketWrapper.writeMessage("text: sentences in ascending order of words");
            return socketWrapper.readObject();
        } catch (IOException|ClassNotFoundException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String findUniqueWordInFirstSentence() {
        try {
            socketWrapper.writeMessage("text: unique word in first sentence");
            return socketWrapper.readObject();
        } catch (IOException|ClassNotFoundException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
