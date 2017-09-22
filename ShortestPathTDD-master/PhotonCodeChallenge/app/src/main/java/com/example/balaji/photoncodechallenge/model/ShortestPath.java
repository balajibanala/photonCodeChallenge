package com.example.balaji.photoncodechallenge.model;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class ShortestPath {
    public HashMap<String, Integer> entire;
    public int[][] inputMatrix;

    public ShortestPath() {
        this.entire = new LinkedHashMap<>();
    }

    /*
    This method generates the 2-D array of integer type from the given input by the user based on
    the comma(,) separated columns and semi-colon(;) separated rows.
    @params String stringMatrix is the input obtained from the user from the EditText.
    @return int[][] matrix 2-D array matrix of type int.
     */
    public int[][] createMatrix(String stringMatrix) {
        int[][] matrix = null;
        if (stringMatrix != null && (!stringMatrix.equals(""))) {
            String[] rows = stringMatrix.split(";");
            matrix = new int[rows.length][rows[0].split(",").length];
            for (int i = 0; i < rows.length; i++) {
                String[] cols = rows[i].split(",");
                for (int j = 0; j < cols.length; j++) {
                    try {
                        matrix[i][j] = Integer.parseInt(cols[j]);
                    } catch (Exception e) {
                        matrix = null;
                    }
                }
            }
        }
        return matrix;
    }

    /*
    This method generates the shortest route and the value of traversed elements
    for Row Matrix, Column Matrix and Regular Matrix separately.
    @params String stringMatrix is the input given by the user in the EditText.
    @return String from the method displayMethod and displays it in the TextView.
     */
    public String shortestRoute(String stringMatrix) {
        inputMatrix = createMatrix(stringMatrix);
        //System.out.println(displayMatrix(inputMatrix));
        String path = null;
        int value = 0;
        boolean check = false;
        if (inputMatrix != null) {
            path = "";
            if (inputMatrix.length == 1) {// Row Matrix
                value = 0;
                for (int i = 0; i < inputMatrix[0].length; i++) {
                    if (value + inputMatrix[0][i] <= 50) {
                        path = path.concat(String.valueOf(1));
                        value = value + inputMatrix[0][i];
                    }
                }
            } else if (inputMatrix[0].length == 1) {// Column Matrix
                value = inputMatrix[0][0];
                for (int i = 0; i < inputMatrix.length; i++) {
                    if (inputMatrix[i][0] < value) {
                        path = String.valueOf(i + 1);
                        value = inputMatrix[i][0];
                    }
                }
            } else {// Regular Matrix
                for (int i = 0; i < inputMatrix.length; i++) {
                    get(path, value, i, 0);
                }
                value = 50;
                int keyLength = 0;
                for (String temp : entire.keySet()) {
                    if (keyLength <= temp.length()) {
                        keyLength = temp.length();
                    }
                }
                for (String temp : entire.keySet()) {
                    //System.out.println("Key : " + temp + " value : " + entire.get(temp));
                    if (temp.length() == keyLength && entire.get(temp) < value) {
                        path = temp;
                        value = entire.get(temp);
                    }
                }
            }
        }
        return displayResult(path, value);
    }

    /*
    This method displays the output in the TextView in the desired format.
    @params String path is the traversed route.
    @params int val is the sum of elements in the traversed route.
    @return String result output in the desired format.
    */
    public String displayResult(String path, int value) {
        boolean check = false;
        String fullPath = "[";
        String message = "No";
        String result = "Invalid Matrix";
        if (inputMatrix != null) {
            if (path.length() == inputMatrix[0].length) {
                check = true;
            }
        }
        if (path != null) {
            result = "";
            for (int i = 0; i < path.length(); i++) {
                fullPath = fullPath.concat(String.valueOf(path.charAt(i))).concat(" ");
            }
            fullPath = fullPath.trim().concat("]");
            if (check) {
                message = "Yes";
            }
            result = result.concat(message.concat("\n").concat(String.valueOf(value).concat("\n")).concat(fullPath));
        }
        return result;
    }

    /*
    This is a recursive method, in the base condition the route traversed until a given
    column is considered as the 'path' and the sum of the elements in the path is considered as value.
    @params String key is the 'path' it is the route.
    @params int val is the 'value' it is the sum of elements in the route.
    @params int row at a given row.
    @params int col at a given column.
     */
    public void get(String key, int val, int row, int column) {
        if (val + inputMatrix[row][column] <= 50) {
            int value = val + inputMatrix[row][column];
            String tempKey = key.concat(String.valueOf(row + 1));
            if (column == inputMatrix[0].length - 1) {
                entire.put(tempKey, value);
            } else {
                if (row == 0) {
                    get(tempKey, value, inputMatrix.length - 1, column + 1);
                    get(tempKey, value, row, column + 1);
                    if (inputMatrix.length > 2) {
                        get(tempKey, value, row + 1, column + 1);
                    }
                } else if (row == inputMatrix.length - 1) {
                    get(tempKey, value, row - 1, column + 1);
                    get(tempKey, value, row, column + 1);
                    if (inputMatrix.length > 2) {
                        get(tempKey, value, 0, column + 1);
                    }
                } else {
                    get(tempKey, value, row - 1, column + 1);
                    get(tempKey, value, row, column + 1);
                    if (inputMatrix.length > 2) {
                        get(tempKey, value, row + 1, column + 1);
                    }
                }
            }
        } else {
            entire.put(key, val);
        }
    }


    /*
    This method is just to display the 2-D array in a matrix format that can be display in the
    TextView.
    @params int[][] input this is 2-D integer array.
    @return String fullMatrix is the matrix to be displayed.
     */
    public String displayMatrix(int[][] input) {
        String fullMatrix = "Invalid Matrix";
        if (input != null) {
            fullMatrix = "";
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    fullMatrix = fullMatrix.concat(String.valueOf(input[i][j])).concat(" ");
                }
                fullMatrix = fullMatrix.concat("\n");
            }
        }
        return fullMatrix;
    }

}
