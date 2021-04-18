package ru.itis.springbootsemester.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.springbootsemester.dto.CountryDto;
import ru.itis.springbootsemester.dto.GenreDto;
import ru.itis.springbootsemester.dto.RestrictionDto;
import ru.itis.springbootsemester.dto.UserDto;
import ru.itis.springbootsemester.security.details.UserDetailsImpl;
import ru.itis.springbootsemester.services.CountriesService;
import ru.itis.springbootsemester.services.GenresService;
import ru.itis.springbootsemester.services.RestrictionsService;
import ru.itis.springbootsemester.services.UsersService;

import java.util.List;

@Controller
@RequestMapping("/")
public class RootController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private GenresService genresService;

    @Autowired
    private CountriesService countriesService;

    @Autowired
    private RestrictionsService restrictionsService;

    @GetMapping
    public String getRootPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        UserDto user = null;
        if (userDetails != null) {
            String email = userDetails.getUsername();
            user = usersService.getUserByEmail(email);
        }
        List<GenreDto> genres = genresService.getAllGenres();
        List<CountryDto> countries = countriesService.getAllCountries();
        List<RestrictionDto> restrictions = restrictionsService.getAllRestrictions();
        model.addAttribute("user", user);
        model.addAttribute("genres", genres);
        model.addAttribute("countries", countries);
        model.addAttribute("restrictions", restrictions);
        return "root";
    }

}
