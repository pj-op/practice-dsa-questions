package readfile;

import readfile.bean.EmployeeEntity;
import readfile.records.EmployeeDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReadCsvFile {
    private static final String CSV_FILE_PATH = "C:\\Users\\Pranjal_Soni\\Downloads\\MOCK_DATA.csv";

    public static void main(String[] args) throws IOException {
        //reading file
//        List<EmployeeEntity> employeeEntities = readingCsvFile(CSV_FILE_PATH);

        //experimenting with streams
//        testStreams(employeeEntities);

//        String c = "c" + (char) (0 + 'a');
//        System.out.println(c);


        //Reduce binary string to zero
        String str = "10110";
//        System.out.println(reduceBinaryStringToZeroOptimal(str));


        String s = "ABCDEFGABC";
//        System.out.println(fetchLIS(s));

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

//        char c = 'a';
//        System.out.println(numIslands(grid));

        String word = "AbcbDBdD";
//        System.out.println(numberOfSpecialChars(word));
        /*int n = 6;
        int[][] edges =
                {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        //{{0, 1}, {1, 2}, {2, 0}};
        int source = 0, destination = 2;
        System.out.println(validPath(n, edges, source, destination));*/

//        System.out.println(tribonacci(4));

        String st = "Java is awesome language";
        System.out.println(firstNonRepeatingChar(st));
    }

    private static String firstNonRepeatingChar(String st) {
        return Arrays.stream(st.split(""))
                .filter(s -> !s.equals(" "))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst().get().getKey();
    }

    public static int tribonacci(int n) {

        if (n <= 2) return n;

        int a = 0;
        int b = 1;
        int c = a + b;
        int res = 0;

        for (int i = 3; i <= n; i++) {
            res = (a + b + c);
            a = b;
            b = c;
            c = res;
        }
        return res;
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> adjList.add(new ArrayList<>()));
        //Prepare Adj list

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            visited[currNode] = true;

            for (int neigh : adjList.get(currNode)) {
                if (neigh == destination) return true;
                if (!visited[neigh]) {
                    queue.add(neigh);
                    visited[neigh] = true;
                }
            }

        }
        return false;
    }

    public static int numberOfSpecialChars(String word) {
        int[] smallChar = new int[26];
        int[] capsChar = new int[26];

        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char l = Character.toLowerCase(c);
                if (smallChar[l - 'a'] >= 1) {
                    capsChar[c - 'A']++;
                }
            } else {
                char m = Character.toUpperCase(c);
                if (capsChar[m - 'A'] >= 1) {
                    capsChar[m - 'A'] = 0;
                    smallChar[c - 'a'] = 0;
                } else {
                    smallChar[c - 'a']++;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (smallChar[i] >= 1 && capsChar[i] >= 1) {
                count++;
            }
        }

        return count;
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int island = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
//                    performDfs(i, j, grid, visited);
                    performBFS(i, j, grid, visited);
                    island++;
                }
            }
        }
        return island;
    }

    private static void performBFS(int row, int col, char[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            visited[currRow][currCol] = true;

            for (int i = 0; i < delCol.length; i++) {
                int nRow = currRow + delRow[i];
                int nCol = currCol + delCol[i];

                if (nRow < n && nCol < m && nRow >= 0 && nCol >= 0 && grid[nRow][nCol] == '1' && !visited[nRow][nCol]) {
                    queue.add(new int[]{nRow, nCol});
                    visited[nRow][nCol] = true;
                }
            }
        }
    }

    private static void performDfs(int row, int col, char[][] grid, boolean[][] visited) {

        int n = grid.length;
        int m = grid[0].length;

        if (row >= n || col >= m || row < 0 || col < 0 || visited[row][col] || grid[row][col] == '0') {
            return;
        }
        visited[row][col] = true;

        performDfs(row - 1, col, grid, visited);
        performDfs(row, col - 1, grid, visited);
        performDfs(row + 1, col, grid, visited);
        performDfs(row, col + 1, grid, visited);
    }

    private static String fetchLIS(String s) {

        int i = 0;
        int j = i + 1;
        int n = s.length();
        int len = 0;
        StringBuilder sb = new StringBuilder();

        while (i < n) {
            char charAtI = s.charAt(i);
            if (sb.indexOf(String.valueOf(charAtI)) == -1) {
                sb.append(charAtI);
            } else break;
            i++;
        }

        System.out.println(sb);

        return null;
    }

    private static int reduceBinaryStringToZeroOptimal(String str) {
        int step = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') step++;
        }
        return step + str.length() - 1;
    }

    private static int reduceBinaryStringToZero(String str) {
        int ans = 0;
        int num = Integer.parseInt(str, 2);

        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            ans++;
        }

        return ans;
    }

    private static void testStreams(List<EmployeeEntity> employeeEntities) {

        //Grouping employee with the salary range


    }

    private static List<EmployeeEntity> readingCsvFile(String csvFilePath) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(csvFilePath))) {
            return stream.skip(1)
                    .skip(0)
                    .map(rec -> rec.split(","))
                    .map(arr -> new EmployeeDto(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2])))
                    .map(ReadCsvFile::convertEmployeeDtoToEmployeeEntity)
                    .collect(Collectors.toList());
        }
    }

    private static EmployeeEntity convertEmployeeDtoToEmployeeEntity(EmployeeDto employeeDto) {
        return new EmployeeEntity(employeeDto.id(), employeeDto.name(), employeeDto.salary());
    }

}
