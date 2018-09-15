package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.main.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static android.support.test.InstrumentationRegistry.getContext;
import static org.junit.Assert.assertNotNull;
@RunWith(AndroidJUnit4.class)
public class AsyntaskTesting {
    @Test
    public void testAsyncTaskTest() {



        final EndpointsAsyncTask asyncTask = (EndpointsAsyncTask) new EndpointsAsyncTask(getContext()).execute();

        String result = null;
        try {
            result = asyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        assertNotNull(result);


    }
}
