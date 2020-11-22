//public List<Menu> getMainMenu() {
//        List<Menu> mainMenu = new ArrayList<>();
//        String menuItemLink;
//        String menuItemRus;
//        int menuItemId;
//        try {
//        connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
//        PreparedStatement preparedStatement = connection.prepareStatement(GET_MAIN_MENU);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//        menuItemId = resultSet.getInt(1);
//        menuItemLink = resultSet.getString(2);
//        menuItemRus = resultSet.getString(3);
//        Menu menuItem = new Menu(menuItemId, menuItemLink, menuItemRus);
//        mainMenu.add(menuItem);
//        connection.close();
//        }
//        } catch (SQLException e) {
//        e.printStackTrace();
//        }
//        return mainMenu;
//        }





//        for (MenuItem menuItem : mainMenuWithAuth) {
//            if (userRole == 1) {
//                for (MenuItem fieldLink : mainMenuWithAuth) {
//                    if (fieldLink.getMenuLink().equals("adminCabinet") || fieldLink.getMenuLink().equals("moderatorCabinet")) {
//                        mainMenuWithAuth.remove(fieldLink);
//                    }
//                }
//            } else if (userRole == 2) {
//                for (MenuItem fieldLink : mainMenuWithAuth) {
//                    if (fieldLink.getMenuLink().equals("userCabinet") || fieldLink.getMenuLink().equals("moderatorCabinet")) {
//                        mainMenuWithAuth.remove(fieldLink);
//                    }
//                }
//            } else if (userRole == 3) {
//                for (MenuItem fieldLink : mainMenuWithAuth) {
//                    if (fieldLink.getMenuLink().equals("userCabinet") || fieldLink.getMenuLink().equals("adminCabinet")) {
//                        mainMenuWithAuth.remove(fieldLink);
//                    }
//                }
//
//            }
//        }