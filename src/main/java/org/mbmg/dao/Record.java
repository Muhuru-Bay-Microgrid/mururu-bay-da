package org.mbmg.dao;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by rpomeroy on 4/26/14.
 */
public class Record {
    private Long recordId;
    private String type;
    private String stationId;
    private LocalDateTime timestamp;
    private Map<String, Double> channelData;
    
    public Record(Long recordNumber, String recordType, String stationID,
            LocalDateTime timestamp, Map<String, Double> channelData) {
        this.recordId = recordNumber;
        this.type = recordType;
        this.stationId = stationID;
        this.timestamp = timestamp;
        this.channelData = channelData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (!channelData.equals(record.channelData)) return false;
        if (!recordId.equals(record.recordId)) return false;
        if (!type.equals(record.type)) return false;
        if (!stationId.equals(record.stationId)) return false;
        if (!timestamp.equals(record.timestamp)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordId.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + stationId.hashCode();
        result = 31 * result + timestamp.hashCode();
        result = 31 * result + channelData.hashCode();
        return result;
    }

    public Long getRecordId() {
        return recordId;
    }

    public String getType() {
        return type;
    }

    public String getStationID() {
        return stationId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Map<String, Double> getChannelData() {
        return channelData;
    }
}
