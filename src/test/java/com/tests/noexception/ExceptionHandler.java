package com.tests.noexception;

import java.io.FileInputStream;
import java.io.IOException;

public interface ExceptionHandler {

    void process(FileInputStream inputStream) throws IOException;


}
