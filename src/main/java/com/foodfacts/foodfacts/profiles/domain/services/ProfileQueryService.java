package com.foodfacts.foodfacts.profiles.domain.services;


import com.foodfacts.foodfacts.profiles.domain.model.aggregates.Profile;
import com.foodfacts.foodfacts.profiles.domain.model.queries.GetAllProfilesQuery;
import com.foodfacts.foodfacts.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.foodfacts.foodfacts.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service

public interface ProfileQueryService {
    /**
     * Handle Get Profile By ID Query
     *
     * @param query The {@link GetProfileByIdQuery} Query
     * @return A {@link Profile} instance if the query is valid, otherwise empty
     */
    Optional<Profile> handle(GetProfileByIdQuery query);

    /**
     * Handle Get Profile By Email Query
     *
     * @param query The {@link GetProfileByEmailQuery} Query
     * @return A {@link Profile} instance if the query is valid, otherwise empty
     */
    Optional<Profile> handle(GetProfileByEmailQuery query);

    /**
     * Handle Get All Profiles Query
     *
     * @param query The {@link GetAllProfilesQuery} Query
     * @return A list of {@link Profile} instances
     */
    List<Profile> handle(GetAllProfilesQuery query);
}
