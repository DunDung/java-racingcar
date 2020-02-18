package domain;

import java.util.ArrayList;
import java.util.List;

import utils.RandomUtils;

public class GameManager {
	private static final int RANDOM_BOUND = 10;

	private final Cars cars;
	private final AttemptNo attemptNo;

	public GameManager(String carNames, String attemptNumber) {
		this.cars = new Cars(CarGenerator.create(carNames));
		this.attemptNo = new AttemptNo(attemptNumber);
	}

	public RacingResults race() {
		List<RacingResult> results = new ArrayList<>();
		int carsSize = cars.getSize();
		for (int count = 0; count < carsSize; count++) {
			RandomNo randomNo = new RandomNo(RandomUtils.getNumber(RANDOM_BOUND));
			RacingResult racingResult = cars.moveByIndex(count, randomNo);
			results.add(racingResult);
		}
		return new RacingResults(results);
	}

	public Cars findWinners() {
		int maxPosition = cars.getMaxPosition();
		List<Car> winners = cars.findByPosition(maxPosition);
		return new Cars(winners);
	}


	public boolean isContinue() {
		return attemptNo.hasNext();
	}
}
