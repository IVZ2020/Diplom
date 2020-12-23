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

//public List<Integer> getListOfIdSendersByCurrentUserId (int userId) {
//        List<Integer> listOfSenders = new ArrayList<>();
//        try {
//        connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
//        PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_OF_ID_SENDERS_BY_ID);
//        preparedStatement.setInt(1, userId);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//        if (listOfSenders.isEmpty()) {
//        int senderId = resultSet.getInt(1);
//        listOfSenders.add(senderId);
//        } else {
//        int senderId = resultSet.getInt(1);
//        int checkElement = listOfSenders.get(listOfSenders.size() - 1);
//        for (int i = listOfSenders.size() - 1; i >= 0; i--) {
//        if (!(checkElement == (senderId))) {
//        listOfSenders.add(senderId);
//        }
//        }
//        }
//        }
//        return listOfSenders;
//        } catch (SQLException e) {
//        e.printStackTrace();
//        }
//        return null;
//        }