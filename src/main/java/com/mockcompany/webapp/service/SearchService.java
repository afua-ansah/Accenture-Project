package com.mockcompany.webapp.service;

import com.mockcompany.webapp.model.ProductItem;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class will create random products from a list of images
 */
@Service
public class SearchService {

    public Collection<ProductItem> searchLogic(String query, Iterable<ProductItem> allItems) {

        List<ProductItem> matchingItems = new ArrayList<>();
        for (ProductItem item : allItems) {
            // TODO: Figure out if the item should be returned based on the query parameter!
            boolean matchesSearch = false;
            boolean hasQuotes = false;
            String name = item.getName();
            String description = item.getDescription();

            if (query.charAt(0) == '"' && query.charAt(query.length() - 1) == '"' )
                hasQuotes = true;

            if (hasQuotes && (name.equals(query.substring(1,query.length() - 1)) || description.equals(query.substring(1,query.length() - 1))))
                matchesSearch = true;
            else if(name.toLowerCase().contains(query.toLowerCase()) || description.toLowerCase().contains(query.toLowerCase()))
                matchesSearch = true;

            if (matchesSearch)
                matchingItems.add(item);
        }
        return matchingItems;
    }
}
