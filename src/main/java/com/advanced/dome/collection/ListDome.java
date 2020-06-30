package com.advanced.dome.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author guohong
 */
public class ListDome {


    private boolean isSkip(String path) {
        Stream<String> stringStream = AuthProvider.getDefaultSkipUrl().stream().map(url -> url.replace(AuthProvider.TARGET, AuthProvider.REPLACEMENT));
        stringStream.forEach(a -> {
            System.out.println(a);
            System.out.println(path.startsWith(a));
        });
        return AuthProvider.getDefaultSkipUrl().stream().map(url -> url.replace(AuthProvider.TARGET, AuthProvider.REPLACEMENT)).anyMatch(path::startsWith);
    }
    public static void main(String[] args) {

        ListDome listDome = new ListDome();
        System.out.println(listDome.isSkip("/test"));

    }


}
