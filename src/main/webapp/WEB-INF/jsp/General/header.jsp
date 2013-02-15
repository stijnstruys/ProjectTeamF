<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<section id="container">

    <header>
        <img id="header_banner" src="../img/header.png" alt="header"/>
        <div class="navbar navbar-inverse">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="/ProjectTeamF-1.0/general/index.html">Team F</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li><a href="/ProjectTeamF-1.0/general/index.html">Home</a></li>
                            <li><a href="/ProjectTeamF-1.0/general/about.html">About</a></li>
                            <li><a href="/ProjectTeamF-1.0/trip/tripOverzicht.html">Trip</a></li>
                        </ul>


                        <ul class="nav pull-right">
                            <li class="pull-right"><a href="/ProjectTeamF-1.0/user/user.html">Registreer</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Aanmelden<b class="caret"></b></a>

                                <ul class="dropdown-menu">


                                    <form name='f' action="<c:url value='/ProjectTeamF-1.0/j_spring_security_check' />"
                                          method='POST'>

                                        <table>
                                            <tr>
                                                <td>User:</td>
                                                <td><input type='text' name='j_username' class="input" placeholder="Username">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Password:</td>
                                                <td><input type='password' name='j_password'class="input" placeholder="Password"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan='2'><input name="submit" type="submit"
                                                                       value="submit"class="btn" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan='2'><input name="reset" type="reset"class="btn" />
                                                </td>
                                            </tr>
                                        </table>

                                    </form>

                                </ul>
                            </li>
                        </ul>
                        <form class="navbar-search pull-right" action="../search/tripSearchResult.html" method="GET">
                            <input id="autocomplete" type="text" class="search-query span2" placeholder="Search trip" name="searchInput">
                        </form>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

    </header>

