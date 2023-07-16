package model;

public enum Position {
    empty(
            """
                       ________________
                      |/        \u001B[31m|\u001B[0m
                      |         \u001B[31m|\u001B[0m
                      |
                      |
                      |
                      |
                      |
                      |
                      |
                     _|___
                    """),
    head(
            """
                       ________________
                      |/        \u001B[31m|\u001B[0m
                      |         \u001B[31m|\u001B[0m
                      |        \u001B[33m(_)\u001B[0m
                      |
                      |
                      |
                      |
                      |
                      |
                     _|___
                    """),
    body(
            """
                       ________________
                      |/        \u001B[31m|\u001B[0m
                      |         \u001B[31m|\u001B[0m
                      |        \u001B[33m(_)\u001B[0m
                      |         \u001B[33m|\u001B[0m
                      |         \u001B[33m|\u001B[0m
                      |
                      |
                      |
                      |
                     _|___
                    """),
    leftHand(
            """
                       ________________
                      |/        \u001B[31m|\u001B[0m
                      |         \u001B[31m|\u001B[0m
                      |       \u001B[33m\\(_)\u001B[0m
                      |        \u001B[33m\\|\u001B[0m
                      |         \u001B[33m|\u001B[0m
                      |
                      |
                      |
                      |
                     _|___
                    """),
    rightHand(
            """
                       ________________
                      |/        \u001B[31m|\u001B[0m
                      |         \u001B[31m|\u001B[0m
                      |       \u001B[33m\\(_)/\u001B[0m
                      |        \u001B[33m\\|/\u001B[0m
                      |         \u001B[33m|\u001B[0m
                      |
                      |
                      |
                      |
                     _|___
                    """),
    leftFoot(
            """
                       ________________
                      |/        \u001B[31m|\u001B[0m
                      |         \u001B[31m|\u001B[0m
                      |       \u001B[33m\\(_)/\u001B[0m
                      |        \u001B[33m\\|/\u001B[0m
                      |         \u001B[33m|\u001B[0m
                      |        \u001B[33m/\u001B[0m
                      |       \u001B[33m/\u001B[0m
                      |
                      |
                     _|___
                    """),
    rightFoot(
            """
                       ________________
                      |/        \u001B[31m|\u001B[0m
                      |         \u001B[31m|\u001B[0m
                      |       \u001B[33m\\(_)/\u001B[0m
                      |        \u001B[33m\\|/\u001B[0m
                      |         \u001B[33m|\u001B[0m
                      |        \u001B[33m/ \\\u001B[0m
                      |       \u001B[33m/   \\\u001B[0m
                      |
                      |
                     _|___
                    """);

    private final String positionName;

    Position(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }
}
