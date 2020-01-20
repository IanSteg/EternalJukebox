package dev.eternalbox.eternaljukebox.stores

import dev.eternalbox.eternaljukebox.data.DataResponse
import dev.eternalbox.eternaljukebox.data.EnumAnalysisService
import dev.eternalbox.eternaljukebox.data.EnumAudioService
import dev.eternalbox.eternaljukebox.data.JukeboxResult

interface AnalysisDataStore {
    suspend fun hasAnalysisStored(service: EnumAnalysisService, id: String): Boolean
    suspend fun canStoreAnalysis(service: EnumAnalysisService, id: String): Boolean
    suspend fun storeAnalysis(service: EnumAnalysisService, id: String, data: ByteArray): JukeboxResult<DataResponse>
    suspend fun getAnalysis(service: EnumAnalysisService, id: String): JukeboxResult<DataResponse>
}

interface AudioDataStore {
    suspend fun hasAudioStored(
        audioService: EnumAudioService,
        analysisService: EnumAnalysisService,
        id: String
    ): Boolean

    suspend fun canStoreAudio(audioService: EnumAudioService, analysisService: EnumAnalysisService, id: String): Boolean
    suspend fun storeAudio(
        audioService: EnumAudioService,
        analysisService: EnumAnalysisService,
        id: String,
        data: ByteArray
    ): JukeboxResult<DataResponse>

    suspend fun getAudio(
        audioService: EnumAudioService,
        analysisService: EnumAnalysisService,
        id: String
    ): JukeboxResult<DataResponse>
}

interface InfoDataStore {
    suspend fun hasTrackInfoStored(service: EnumAnalysisService, id: String): Boolean
    suspend fun canStoreTrackInfo(service: EnumAnalysisService, id: String): Boolean
    suspend fun storeTrackInfo(service: EnumAnalysisService, id: String, data: ByteArray): JukeboxResult<DataResponse>
    suspend fun getTrackInfo(service: EnumAnalysisService, id: String): JukeboxResult<DataResponse>
}