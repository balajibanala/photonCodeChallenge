package com.example.balaji.photoncodechallenge;

import java.util.HashMap;
import java.util.LinkedHashMap;

class ShortestRoute {

    private HashMap<String, Integer> entire;
    private int[][] inputMatrix;
    ShortestRoute shortestRoute; // = new ShortestRoute();

    public int[][] getInputMatrix() {
        return inputMatrix;
    }

    public void setInputMatrix(int[][] inputMatrix) {
        this.inputMatrix = inputMatrix;
    }

    public ShortestRoute() {
        this.entire = new HashMap<>();
        //shortestRoute = new ShortestRoute();
    }

    public HashMap getEntire() {
        return entire;
    }

    public void setEntire(HashMap entire) {
        this.entire = entire;
    }

    /*
    This method generates the shortest route and the value of traversed elements
    for Row Matrix, Column Matrix and Regular Matrix separately.
    @params String stringMatrix is the input given by the user in the EditText.
    @return String from the method displayMethod and displays it in the TextView.
     */
    public String getShortestRoute(String stringMatrix) {
        String path = null;
        int value = 0;
        shortestRoute = new ShortestRoute();
        shortestRoute.setInputMatrix(getMatrix(stringMatrix));
        inputMatrix = shortestRoute.getInputMatrix();
        if (inputMatrix != null) {
            path = "";
            if (inputMatrix.length == 1) {// Row Matrix
                path = getPathForRowMatrix();
            } else if (inputMatrix[0].length == 1) {// Column Matrix
                path = getPathForColumnMatrix();
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
                    if (temp.length() == keyLength && entire.get(temp) <= value) {
                        path = temp;
                        value = entire.get(temp);
                    }
                }
            }
        }
        return displayResult(path);
    }

    /*
    This method generates the 2-D array of integer type from the given input by the user based on
    the comma(,) separated columns and semi-colon(;) separated rows.
    @params String stringMatrix is the input obtained from the user from the EditText.
    @return int[][] matrix 2-D array matrix of type int.
     */
    private int[][] getMatrix(String stringMatrix) {
        int[][] matrix = null;
        if (stringMatrix != null && (!stringMatrix.equals(""))) {
            String[] rows = stringMatrix.trim().split(";");
            matrix = new int[rows.length][rows[0].split(",").length];
            for (int i = 0; i < rows.length; i++) {
                String[] cols = rows[i].trim().split(",");
                for (int j = 0; j < cols.length; j++) {
                    try {
                        matrix[i][j] = Integer.parseInt(cols[j].trim());
                    } catch (Exception e) {
                        matrix = null;
                    }
                }
            }
        }
        return matrix;
    }

    /*
    This method displays the output in the TextView in the desired format.
    @params String path is the traversed route.
    @return String result output in the desired format.
    */
    private String displayResult(String path) {
        boolean check = false;
        String fullPath = "[";
        String message = "No";
        int value = 0;
        String result = "Invalid Matrix";
        if (inputMatrix != null) {
            for (int i = 0; i < path.trim().length(); i++) {
                value = value + inputMatrix[(Character.getNumericValue(path.charAt(i)) - 1)][i];
            }
            if (path != null) {
                if (path.length() == inputMatrix[0].length) {
                    check = true;
                }
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
        }
        return result;
    }

    /*
    This is a recursive method, in the base condition the route traversed until a given
    column is considered as the 'path' and the sum of the elements in the path is considered as value.
    @params String path is the 'path' it is the route.
    @params int initialValue is the 'value' it is the sum of elements in the route.
    @params int row at a given row.
    @params int col at a given column.
     */
    private void get(String path, int initialValue, int row, int column) {
        if (initialValue + inputMatrix[row][column] <= 50) {
            int value = initialValue + inputMatrix[row][column];
            String tempKey = path.concat(String.valueOf(row + 1));
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
            entire.put(path, initialValue);
        }
    }

    /*
    This method is to calculate the path for a column matrix
    @returns String path of the shortest route
     */
    private String getPathForColumnMatrix() {
        String path = "";
        int value1 = inputMatrix[0][0];
        for (int i = 0; i < inputMatrix.length; i++) {
            if (inputMatrix[i][0] < value1 && inputMatrix[i][0] <= 50) {
                path = String.valueOf(i + 1);
                value1 = inputMatrix[i][0];
            }
        }
        return path;
    }

    /*
    This method is to calculate the path for a row matrix
    @returns String path of the shortest route
     */
    private String getPathForRowMatrix() {
        String path = "";
        int value1 = 0;
        boolean flag = true;
        for (int i = 0; i < inputMatrix[0].length; i++) {
            if (flag && value1 + inputMatrix[0][i] <= 50) {
                path = path.concat(String.valueOf(1));
                value1 = value1 + inputMatrix[0][i];
            } else {
                flag = false;
            }
        }
        return path;
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
