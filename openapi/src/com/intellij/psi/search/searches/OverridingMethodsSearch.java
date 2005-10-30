/*
 * Copyright (c) 2005 Your Corporation. All Rights Reserved.
 */
package com.intellij.psi.search.searches;

import com.intellij.psi.PsiMethod;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.util.Query;
import com.intellij.util.QueryFactory;

/**
 * @author max
 */
public class OverridingMethodsSearch extends QueryFactory<PsiMethod, OverridingMethodsSearch.SearchParameters> {
  public static OverridingMethodsSearch INSTANCE = new OverridingMethodsSearch();

  public static class SearchParameters {
    private final PsiMethod myMethod;
    private final SearchScope myScope;
    private final boolean myCheckDeep;

    public SearchParameters(final PsiMethod aClass, SearchScope scope, final boolean checkDeep) {
      myMethod = aClass;
      myScope = scope;
      myCheckDeep = checkDeep;
    }

    public PsiMethod getMethod() {
      return myMethod;
    }

    public boolean isCheckDeep() {
      return myCheckDeep;
    }

    public SearchScope getScope() {
      return myScope;
    }
  }

  private OverridingMethodsSearch() {
  }

  public static Query<PsiMethod> search(final PsiMethod method, SearchScope scope, final boolean checkDeep) {
    return INSTANCE.createQuery(new SearchParameters(method, scope, checkDeep));
  }

  public static Query<PsiMethod> search(final PsiMethod method, final boolean checkDeep) {
    return search(method, GlobalSearchScope.allScope(method.getProject()), checkDeep);
  }

  public static Query<PsiMethod> search(final PsiMethod method) {
    return search(method, true);
  }
}
