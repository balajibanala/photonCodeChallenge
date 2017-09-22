package com.example.balaji.photoncodechallenge;


import com.example.balaji.photoncodechallenge.model.ShortestPath;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShortestPathTest {

    ShortestPath shortestPath = new ShortestPath();

    @Test
    public void normalMatrix1Test(){
        assertEquals("Yes\n" +
                "16\n" +
                "[1 2 3 4 4 5]",shortestPath.shortestRoute("3,4,1,2,8,6;6,1,8,2,7,4;5,9,3,9,9,5;8,4,1,3,2,6;3,7,2,8,6,4;"));
    }

    @Test
    public void normalMatrix2Test(){
        assertEquals("Yes\n" +
                "11\n" +
                "[1 2 1 5 4 5]",shortestPath.shortestRoute("3,4,1,2,8,6;6,1,8,2,7,4;5,9,3,9,9,5;8,4,1,3,2,6;3,7,2,1,2,3;"));
    }

    @Test
    public void RoutelessThanFiftyTest(){
        assertEquals("No\n" +
                "48\n" +
                "[1 1 1]",shortestPath.shortestRoute("19,10,19,10,19;21,23,20,19,12;20,12,20,11,10;"));
    }

    @Test
    public void rowMatrixTest(){
        assertEquals("Yes\n" +
                "26\n" +
                "[1 1 1 1 1]",shortestPath.shortestRoute("5,8,5,3,5;"));
    }

    @Test
    public void colMatrixTest(){
        assertEquals("Yes\n" +
                "3\n" +
                "[4]",shortestPath.shortestRoute("5;8;5;3;5;"));
    }

    @Test
    public void nonNumericTest(){
        assertEquals("Invalid Matrix",shortestPath.shortestRoute("5,4,H;8,M,7;5,7,5;"));
    }

    @Test
    public void emptyMatrixTest(){
        assertEquals("Invalid Matrix",shortestPath.shortestRoute(""));
    }

    @Test
    public void firstElementsMoreThanFiftyTest(){
        assertEquals("No\n" +
                "0\n" +
                "[]",shortestPath.shortestRoute("69,10,19,10,19;51,23,20,19,12;60,12,20,11,10;"));
    }

    @Test
    public void onlyOneElementAboveFiftyTest(){
        assertEquals("Yes\n" +
                "14\n" +
                "[3 2 1 3]",shortestPath.shortestRoute("60,3,3,6;6,3,7,9;5,6,8,3;"));
    }

    @Test
    public void negativeValuesTest(){
        assertEquals("Yes\n" +
                "0\n" +
                "[2 3 4 1]",shortestPath.shortestRoute("6,3,-5,9;-5,2,4,10;3,-2,6,10;6,-1,-2,10;"));
    }

    @Test
    public void completePath(){
        assertEquals("Yes\n" +
                "10\n" +
                "[4 4]",shortestPath.shortestRoute("51,51;0,51;51,51;5,5;"));
    }

    @Test
    public void longerIncompletePath(){
        assertEquals("No\n" +
                "10\n" +
                "[4 4]",shortestPath.shortestRoute("51,51,51;0,51,51;51,51,51;5,5,51;"));
    }

    @Test
    public void largeNumberOfColumns(){
        assertEquals("Yes\n" +
                "20\n" +
                "[1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]",shortestPath.shortestRoute("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1;2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2;"));
    }
}
