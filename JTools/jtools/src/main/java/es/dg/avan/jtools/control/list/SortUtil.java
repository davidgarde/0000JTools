package es.dg.avan.jtools.control.list;

import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;

public class SortUtil
{    
    public static <T> List<T> sort(List<T> list, String sortByProperty)
    {
            Collections.sort(list, new BeanComparator<T>(sortByProperty));
            return list;
    }
}
