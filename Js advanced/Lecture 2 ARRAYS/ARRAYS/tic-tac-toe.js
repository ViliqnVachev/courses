function solve(positions) {
    let board = initBoard();
    let x = 'X';
    let o = 'O';

    //Play the game
    while (positions.length != 0) {
        let isCheckedX = false;
        let isCheckedO = false;
        //Player X turn
        while (!isCheckedX) {
            let playerX = getPostion(positions);
            isCheckedX = isFill(playerX, x, board);
        }
        if (isPlayerWins(board, x)) {
            console.log(`Player ${x} wins!`);
            printBoard(board);
            return;
        }
        if (!isEmtpySpaces(board)) {
            console.log('The game ended! Nobody wins :(');
            printBoard(board);
            return;
        }

        //Player O turn
        while (!isCheckedO) {
            let playerO = getPostion(positions);
            isCheckedO = isFill(playerO, o, board);
        }
        if (isPlayerWins(board, o)) {
            console.log(`Player ${o} wins!`);
            printBoard(board);
            return;
        }
        if (!isEmtpySpaces(board)) {
            console.log('The game ended! Nobody wins :(');
            printBoard(board);
            return;
        }



    }

    function printBoard(board) {
        board.forEach(row => console.log(row.join('\t')));
    }

    function isEmtpySpaces(board) {
        for (let row = 0; row < board.length; row++) {
            for (let col = 0; col < board[row].length; col++) {
                if (board[row][col] === false) {
                    return true;
                }
            }
        }
        return false;
    }

    function isPlayerWins(board, sing) {
        //check row
        for (let row = 0; row < board.length; row++) {
            let result = 0;
            for (let col = 0; col < board[row].length; col++) {
                if (board[row][col] === sing) {
                    result++;
                }
            }
            if (result === 3) {
                return true;
            }
        }

        //check col
        for (let row = 0; row < board.length; row++) {
            let result = 0;
            for (let col = 0; col < board[row].length; col++) {
                if (board[col][row] === sing) {
                    result++;
                }
            }
            if (result === 3) {
                return true;
            }
        }

        //check diagonals
        let firstDiagonal = 0;
        let secondDiagonal = 0;
        for (let i = 0; i < board.length; i++) {
            if (board[i][i] == sing) {
                firstDiagonal++;
            }
            if (board[i][board[i].length - 1 - i] == sing) {
                secondDiagonal++;
            }
            if (firstDiagonal === 3 || secondDiagonal === 3) {
                return true;
            }
        }
    }
    function isFill(position, player, board) {
        let [x1, y1] = position.split(' ').map(e => Number(e));
        let boardPositionSing = board[x1][y1];
        if (boardPositionSing !== false) {
            console.log("This place is already taken. Please choose another!")
            return false
        } else {
            board[x1][y1] = player;
            return true;
        }
    }
    function getPostion(positions) {
        return positions.shift();
    }
    function initBoard() {
        return [
            [false, false, false],
            [false, false, false],
            [false, false, false]
        ];
    }

}

console.log(
    solve(
        ["0 0",
            "0 0",
            "1 1",
            "0 1",
            "1 2",
            "0 2",
            "2 2",
            "1 2",
            "2 2",
            "2 1"]

    )
);