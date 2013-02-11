<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                        <a class="brand" href="/ProjectTeamF-1.0/General/index.html">Team F</a>
                        <div class="nav-collapse collapse">
                            <ul class="nav">
                                <li class="active"><a href="/ProjectTeamF-1.0/General/index.html">Home</a></li>
                                <li><a href="#about">About</a></li>
                                <li><a href="/ProjectTeamF-1.0/trip/trip.html">Trip</a></li>
                            </ul>

                           <ul class="nav pull-right">
                            <li class="pull-right"><a href="/ProjectTeamF-1.0/user/user.html">Registreer</a></li>
                              <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Aanmelden<b class="caret"></b></a>

                                <ul class="dropdown-menu">

                                  <form id="header_login_form" method="POST"  commandName="user" action="/ProjectTeamF-1.0/user/login.html">
                                      <input path="username"class="input" placeholder="Email" />
                                      <input path="password" class="input" placeholder="Password" />
                                      <label class="checkbox">
                                        <input type="checkbox"> Aangemeld blijven
                                      </label>
                                      <button type="submit" class="btn">Aanmelden</button>
                                  </form>
                                </ul>
                              </li>
                            </ul>
                            <form class="navbar-search pull-right" action="">
                            <input type="text" class="search-query span2" placeholder="Search trip">
                          </form>
                        </div><!--/.nav-collapse -->
                    </div>
                </div>
            </div>

     </header>

