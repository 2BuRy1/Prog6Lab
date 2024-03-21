package Interfaces;

import Network.Request;
import Network.Response;

/**
 * Интерфейс для запуска команд
 */
public interface Executor {
    Response execute(String args, Request request);
}
