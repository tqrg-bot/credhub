package org.cloudfoundry.credhub.requests;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.cloudfoundry.credhub.ErrorMessages;
import org.cloudfoundry.credhub.helpers.JsonTestHelper;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RegenerateRequestTest {
  @Test
  public void whenNameIsMissing__isInvalid() {
    final Set<ConstraintViolation<RegenerateRequest>> violations = JsonTestHelper.deserializeAndValidate("{}",
      RegenerateRequest.class);

    MatcherAssert.assertThat(violations, Matchers.contains(JsonTestHelper.hasViolationWithMessage(ErrorMessages.MISSING_NAME)));
  }

}
