package com.raczkowska.citynav.station;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StationRestController.class)
class StationRestControllerTest {

	@Test
	void whenGetStationStateThenReturnJsonArray()
		throws Exception {

		StationResponse stationResponse = StationResponse.builder().name("name")
			.availableBikesAmount(11)
			.occupiedPositionAmount(3)
			.availablePositionAmount(3)
			.build();

		List<StationResponse> stationResponseList = Collections.singletonList(stationResponse);

		given(service.getStationsState()).willReturn(stationResponseList);

		mvc.perform(get("/api/stations")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].name", is(stationResponse.getName())));
	}

	@Autowired
	private MockMvc mvc;

	@MockBean
	private StationService service;

}
