package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;

public class AttemptNoTest {
	@Test
	void createAttemptNumber_적합한_횟수() {
		new AttemptNo("1");
	}

	@Test
	void createAttemptNumber_부적합한_횟수_문자() {
		assertThatThrownBy(() -> new AttemptNo("타미"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void createAttemptNumber_부적합한_횟수_음수() {
		assertThatThrownBy(() -> new AttemptNo("-1"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void hasNextTest_1이상() {
		AttemptNo attemptNo = new AttemptNo("1");
		assertThat(attemptNo.hasNext()).isTrue();
	}

	@Test
	void hasNextTest_1미만() {
		AttemptNo attemptNo = new AttemptNo("1");
		attemptNo.next();        // No -> 0
		assertThat(attemptNo.hasNext()).isFalse();
	}

	@Test
	void nextTest() {
		AttemptNo attemptNo = new AttemptNo("2");
		assertThat(attemptNo.next()).isEqualTo(2);
		assertThat(attemptNo.next()).isEqualTo(1);
	}
}
