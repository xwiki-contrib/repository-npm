/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.contrib.repository.npm.internal.version;

import org.xwiki.extension.version.Version;
import org.xwiki.extension.version.VersionRange;

import com.github.yuchi.semver.Range;

public class NpmVersionRange implements VersionRange
{
    private final Range range;

    private final String raweVersionRange;

    public NpmVersionRange(String rawVersionRange)
    {
        this.raweVersionRange = rawVersionRange;
        this.range = new Range(rawVersionRange, false);
    }

    @Override public boolean containsVersion(Version version)
    {
        return range.test(new com.github.yuchi.semver.Version(version.getValue()));
    }

    @Override public String getValue()
    {
        return raweVersionRange;
    }

    @Override public boolean isCompatible(VersionRange versionRange)
    {
        return true;
        // TODO: 08.08.2017 to implement in future
    }

    @Override public String toString()
    {
        return raweVersionRange;
    }
}
