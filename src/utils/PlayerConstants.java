package utils;

public enum PlayerConstants {

    RUNNING(0),
    IDLE(1),
    JUMPING(2),
    FALLING(3),
    GROUND(4),
    HIT(5),
    ATTACK_1(6),
    ATTACK_JUMP_1(7),
    ATTACK_JUMP_2(8);

    PlayerConstants(int i) {
    }

    public static int getSpriteAmount(PlayerConstants playerConstants){

        switch (playerConstants) {
            case RUNNING -> {
                return 6;
            }
            case IDLE -> {
                return 5;
            }
            case HIT -> {
                return 4;
            }
            case JUMPING, ATTACK_1, ATTACK_JUMP_1,ATTACK_JUMP_2 -> {
                return 3; }
            case  GROUND-> {
                return 2;
            }case FALLING -> {

            }default -> {
                return 1;
            }

        }
    }
}
