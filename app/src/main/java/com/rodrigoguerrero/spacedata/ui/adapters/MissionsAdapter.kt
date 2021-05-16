package com.rodrigoguerrero.spacedata.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rodrigoguerrero.spacedata.data.SpaceMission
import com.rodrigoguerrero.spacedata.databinding.MissionItemBinding
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MissionsAdapter @Inject constructor() :
    RecyclerView.Adapter<MissionsAdapter.MissionViewHolder>() {

    private val missions = mutableListOf<SpaceMission>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionViewHolder {
        val binding = MissionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MissionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MissionViewHolder, position: Int) {
        holder.bind(missions[position])
    }

    override fun getItemCount() = missions.size

    fun addItems(missions: List<SpaceMission>) {
        this.missions.clear()
        this.missions.addAll(missions)
        notifyDataSetChanged()
    }

    inner class MissionViewHolder(private val binding: MissionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mission: SpaceMission) {
            with(binding) {
                missionName.text = mission.name
                missionCrew.text = mission.crew
                missionYear.text =
                    SimpleDateFormat("MMMM d, yyyy", Locale.getDefault()).format(mission.date.time)
                Picasso.get().load(mission.image).into(missionImage)
            }
        }
    }
}