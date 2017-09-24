package com.example.balaji.photoncodechallenge;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestRouteTest {


    ShortestRoute shortestRoute = new ShortestRoute();
    String input = new String();
    String output = new String();

    @Test
    public void shortestPath_No_Input_Matrix_Test() throws Exception {
        input = shortestRoute.getShortestRoute("");
        output = "Invalid Matrix";
        assertEquals(output, input);
    }

    @Test
    public void shortestPath_Non_Numeric_Matrix_Test() throws Exception {
        input = shortestRoute.getShortestRoute("5,4,H;8,M,7;5,7,5;");
        output = "Invalid Matrix";
        assertEquals(output, input);
    }

    @Test
    public void shortestPath_Single_Row_Matrix_Test() throws Exception {
        input = shortestRoute.getShortestRoute("5,8,5,3,5;");
        output = "Yes\n26\n[1 1 1 1 1]";
        assertEquals(output, input);
    }

    @Test
    public void shortestPath_Single_Column_Matrix_Test() throws Exception {
        input = shortestRoute.getShortestRoute("5;8;5;3;5;");
        output = "Yes\n3\n[4]";
        assertEquals(output, input);
    }

    @Test
    public void shortestPath_Negative_Values_Matrix_Test() throws Exception {
        input = shortestRoute.getShortestRoute("6,3,-5,9;-5,2,4,10;3,-2,6,10;6,-1,-2,10;");
        output = "Yes\n0\n[2 3 4 1]";
        assertEquals(output,input );
    }

    @Test
    public void shortestRoute_Regular_One_Matrix_Test() throws Exception {
        input = shortestRoute.getShortestRoute("3,4,1,2,8,6;6,1,8,2,7,4;5,9,3,9,9,5;8,4,1,3,2,6;3,7,2,8,6,4;");
        output = "Yes\n16\n[1 2 3 4 4 5]";
        assertEquals(output,input );
    }

    @Test
    public void shortestRoute_Regular_Two_Matrix_Test() throws Exception {
        input = shortestRoute.getShortestRoute("3,4,1,2,8,6;6,1,8,2,7,4;5,9,3,9,9,5;8,4,1,3,2,6;3,7,2,1,2,3;");
        output = "Yes\n11\n[1 2 1 5 4 5]";
        assertEquals(output, input );
    }

    @Test
    public void shortestRoute_Sum_Exceeds_Fifty_Matrix_Test() throws Exception {
        input = shortestRoute.getShortestRoute("19,10,19,10,19;21,23,20,19,12;20,12,20,11,10;");
        output = "No\n48\n[1 1 1]";
        assertEquals(output, input);
    }

    @Test
    public void shortestRoute_All_First_Elements_More_Than_FiFty_Matrix_Test() throws Exception {
        input = shortestRoute.getShortestRoute("69,10,19,10,19;51,23,20,19,12;60,12,20,11,10;");
        output = "No\n0\n[]";
        assertEquals(output, input);
    }

    @Test
    public void shortestRoute_Only_One_Element_More_Than_Fifty_Matrix_Test() throws Exception {
        input = shortestRoute.getShortestRoute("60,3,3,6;6,3,7,9;5,6,8,3;");
        output = "Yes\n14\n[3 2 1 3]";
        assertEquals(output, input );
    }

    @Test
    public void shortestRoute_Two_Column_Matrix_Test() throws Exception {
        input = shortestRoute.getShortestRoute("51,51;0,51;51,51;5,5;");
        output = "Yes\n10\n[4 4]";
        assertEquals(output, input);
    }

    @Test
    public void shortestRoute_Incomplete_Path_Matrix_Test() throws Exception {
        input = shortestRoute.getShortestRoute("51,51,51;0,51,51;51,51,51;5,5,51;");
        output = "No\n10\n[4 4]";
        assertEquals(output, input);
    }

    @Test
    public void shortestRoute_Large_Number_Columns_Matrix_Test() {
        input = shortestRoute.getShortestRoute("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1;2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2;");
        output = "Yes\n20\n[1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]";
        assertEquals(output, input);
    }
}
