/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) ${currentYear}-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package ${package}.${pluginFormat}.internal.util;

import java.util.HashMap;
import java.util.Map;

import org.sonatype.goodies.testsupport.TestSupport;
import org.sonatype.nexus.repository.view.matchers.token.TokenMatcher;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class ${pluginClass}PathUtilsTest
    extends TestSupport
{
  private ${pluginClass}PathUtils underTest;

  @Mock
  TokenMatcher.State state;

  private Map<String, String> tokens;

  @Before
  public void setUp() {
    underTest = new ${pluginClass}PathUtils();
    tokens = setupTokens("myTokenValue");
    when(state.getTokens()).thenReturn(tokens);
  }

  @Test
  public void buildAssetPath() {
    String result = underTest.buildAssetPath(state, ${pluginClass}PathUtils.PACKAGE_FILENAME);

    assertThat(result, is(equalTo("/myTokenValue/myPackageFilename.txt")));
  }

  private Map<String, String> setupTokens(final String tokenValue) {
    Map<String, String> tokens = new HashMap<>();
    tokens.put("myTokenName", tokenValue);

    return tokens;
  }
}
