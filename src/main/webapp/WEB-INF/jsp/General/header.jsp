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
                            <c:if  test="${empty currentUser}">
                            <li class="pull-right"><a href="/ProjectTeamF-1.0/user/user.html">Registreer</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Aanmelden<b class="caret"></b></a>

                                <ul class="dropdown-menu">
                                    <form name='f' action="<c:url value='/ProjectTeamF-1.0/j_spring_security_check' />"
                                          method='POST'>
                                        <div id="header_nav_login">
                                            <input type='text' name='j_username' class="input" placeholder="Username">
                                            <input type='password' name='j_password'class="input" placeholder="Password"/>

                                            <div id="header_nav_login_btn">
                                                <input name="submit" type="submit" value="Log in" class="btn" />
                                                <input name="reset" type="reset" class="btn" value="Reset" />
                                            </div>
                                        </div>
                                    </form>
                                </ul>
                            </li>
                            </c:if>
                            <c:if  test="${!empty currentUser}">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Welcome ${currentUser}<b class="caret"></b></a>

                                    <ul class="dropdown-menu">
                                        <li><a href="/ProjectTeamF-1.0/user/profile.html">Profile <i class="icon-tags pull-right"></i></a> </li>
                                        <li class="divider"></li>
                                        <li><a href="/ProjectTeamF-1.0/user/myTrips.html">My trips <i class="icon-tags pull-right"></i></a> </li>
                                        <li class="divider"></li>
                                       <li><a href="/ProjectTeamF-1.0/j_spring_security_logout">Log Out <i class="icon-off pull-right"></i></a> </li>
                                    </ul>
                                </li>
                            </c:if>
                        </ul>
                        <form class="navbar-search pull-right" action="../search/tripSearchResult.html" method="GET">
                            <input id="autocomplete" type="text" class="search-query span2" placeholder="Search trip" name="searchInput">
                        </form>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

    </header>

