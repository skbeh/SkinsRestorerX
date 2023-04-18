/*
 * SkinsRestorer
 *
 * Copyright (C) 2022 SkinsRestorer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */
package net.skinsrestorer.shared.storage.model.cache;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class MojangCacheData {
    private final boolean isPremium;
    private final UUID uniqueId; // Null if not premium
    private final long timestamp;

    public static MojangCacheData of(boolean isPremium, UUID uniqueId, long timestamp) {
        if (isPremium && uniqueId == null)
            throw new IllegalArgumentException("uniqueId cannot be null if isPremium is true");

        if (!isPremium && uniqueId != null)
            throw new IllegalArgumentException("uniqueId must be null if isPremium is false");

        return new MojangCacheData(isPremium, uniqueId, timestamp);
    }
}
