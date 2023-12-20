package org.example;

class Solution {
    public static void moveRobot(RobotConnectionManager connectionManager, int toX, int toY) throws RobotConnectionException {

        for (int i = 0; i < 3; i++) {
            try (RobotConnection robot = connectionManager.getConnection()) {
                robot.moveRobotTo(toX, toY);
                i = 3;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    RobotConnection robot = connectionManager.getConnection();
                    robot.close();
                    throw e;
                }
            } catch (Exception e) {
                RobotConnection robot = connectionManager.getConnection();
                robot.close();
                throw e;
            }
        }
    }
}
