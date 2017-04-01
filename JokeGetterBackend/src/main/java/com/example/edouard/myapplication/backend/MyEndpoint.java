/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.edouard.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.jokegetter.JokeGetter;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.edouard.example.com",
                ownerName = "backend.myapplication.edouard.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    private JokeGetter jokeGetter = new JokeGetter();
    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        JokeGetter jokeGetter = new JokeGetter();
        String joke = jokeGetter.getJoke();
        MyBean response = new MyBean();
        response.setData("Joke for " + name + ": " + joke);

        return response;
    }

    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        String joke = jokeGetter.getJoke();
        MyBean response = new MyBean();
        response.setData(joke);

        return response;
    }

}
